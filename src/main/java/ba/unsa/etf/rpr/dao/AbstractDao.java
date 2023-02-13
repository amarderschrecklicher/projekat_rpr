package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Idable;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import java.sql.*;
import java.util.*;

/**
 * Abstract class that implements core DAO CRUD methods for every entity
 */
public abstract class AbstractDao<T extends Idable> implements Dao<T>{
    private Connection connection;
    private String tableName;

    public AbstractDao(String tableName) {
        try{
            this.tableName = tableName;
            Properties p = new Properties();
            p.load(ClassLoader.getSystemResource("properties/prp.properties").openStream());
            String url = p.getProperty("db.url");
            String username = p.getProperty("db.username");
            String password = p.getProperty("db.password");
            this.connection = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    public Connection getConnection(){
        return this.connection;
    }

    public void setConnection(Connection connection){
        this.connection=connection;
    }

    public abstract T row2object(ResultSet rs) throws Exceptionss, SQLException;

    public abstract Map<String, Object> object2row(T object);

    public T getById(int id) throws Exceptionss {
        if(tableName.equals("Property")){
            return executeQueryUnique("SELECT * FROM "+this.tableName+" WHERE "+this.tableName+"ID = ?", new Object[]{id});
        }
       return executeQueryUnique("SELECT * FROM "+this.tableName+" WHERE id"+this.tableName+" = ?", new Object[]{id});
    }

    public List<T> getAll() throws Exceptionss {
        return executeQuery("SELECT * FROM "+ tableName, null);
    }
    public void delete(int id) throws Exceptionss {
        String sql = "DELETE FROM "+tableName+" WHERE PropertyID = ?";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new Exceptionss(e.getMessage(), e);
        }
    }

    public T add(T item) throws Exceptionss{
        Map<String, Object> row = object2row(item);
        Map.Entry<String, String> columns = prepareInsertParts(row);

        if(columns.getKey().endsWith(",")){
            String a = columns.getKey();
            String b = columns.getValue();
            Map.Entry<String, String> ne = new AbstractMap.SimpleEntry<String,String> (a.substring(0,a.length()-1),b.substring(0,b.length()-1));
            columns = ne;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO ").append(tableName);
        builder.append(" (").append(columns.getKey()).append(") ");
        builder.append("VALUES (").append(columns.getValue()).append(")");
        System.out.println(builder);
        try{
            PreparedStatement stmt = getConnection().prepareStatement(builder.toString(), Statement.RETURN_GENERATED_KEYS);
            // bind params. IMPORTANT treeMap is used to keep columns sorted so params are bind correctly
            int counter = 1;
            for (Map.Entry<String, Object> entry: row.entrySet()) {
                if (entry.getKey().equals("id")) continue; // skip ID
                stmt.setObject(counter, entry.getValue());
                counter++; System.out.print(entry.getValue()+" ");
            }
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next(); // we know that there is one key
            item.setId(rs.getInt(1)); //set id to return it back/

            return item;
        }catch (SQLException e){
            throw new Exceptionss(e.getMessage(), e);
        }
    }

    public T update(T item) throws Exceptionss{
        Map<String, Object> row = object2row(item);
        String updateColumns = prepareUpdateParts(row);
        StringBuilder builder = new StringBuilder();



        builder.append("UPDATE ")
                .append(tableName)
                .append(" SET ")
                .append(updateColumns);
                if(tableName.equals("Property")) {
                builder.append(" WHERE " + tableName + "ID = ?");
                }
                else{
                    builder.append(" WHERE id" + tableName + " = ?");
                }
        try{
            PreparedStatement stmt = getConnection().prepareStatement(builder.toString());
            int counter = 1;
            for (Map.Entry<String, Object> entry: row.entrySet()) {
                if (entry.getKey().equals("id")) continue; // skip ID
                stmt.setObject(counter, entry.getValue());
                counter++;
            }

            stmt.setObject(counter, item.getId());


            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            throw new Exceptionss(e.getMessage(), e);
        }
    }

    public List<T> executeQuery(String query, Object[] params) throws  Exceptionss{
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            if (params != null){
                for(int i = 1; i <= params.length; i++){
                    stmt.setObject(i, params[i-1]);
                }
            }
            ResultSet rs = stmt.executeQuery();
            ArrayList<T> resultList = new ArrayList<>();
            while (rs.next()) {
                resultList.add(row2object(rs));
            }
            return resultList;
        } catch (SQLException e) {
            throw new Exceptionss(e.getMessage(), e);
        }
    }

    /**
     * Utility for query execution that always return single record
     * @param query - query that returns single record
     * @param params - list of params for sql query
     * @return Object
     * @throws Exceptionss in case when object is not found
     */
    public T executeQueryUnique(String query, Object[] params) throws Exceptionss{
        List<T> result = executeQuery(query, params);
        if (result != null && result.size() == 1){
            return result.get(0);
        }else{
            throw new Exceptionss("Object not found");
        }
    }

    /**
     * Accepts KV storage of column names and return CSV of columns and question marks for insert statement
     * Example: (id, name, date) ?,?,?
     */
    private Map.Entry<String, String> prepareInsertParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();
        StringBuilder questions = new StringBuilder();

        int counter = 0;
        if(tableName.equals("Reservations")){
            counter = 1;
        }
        for (Map.Entry<String, Object> entry: row.entrySet()) {
            counter++;
            if (entry.getKey().equals("id")) {
                continue; //skip insertion of id due autoincrement
            }
            columns.append(entry.getKey());
            questions.append("?");
            if (row.size()-1 != counter ) {
                columns.append(",");
                questions.append(",");
            }
        }
        return new AbstractMap.SimpleEntry<String,String>(columns.toString(), questions.toString());
    }

    /**
     * Prepare columns for update statement id=?, name=?, ...
     * @param row
     * @return
     */
    private String prepareUpdateParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();

        int counter = 0;
        for (Map.Entry<String, Object> entry: row.entrySet()) {
            counter++;
            if (entry.getKey().equals("id")) continue; //skip update of id due where clause
            columns.append(entry.getKey()).append("= ?");
            if (row.size() - 1 != counter) {
                columns.append(",");
            }
        }
        return columns.toString();
    }
}
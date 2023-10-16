package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoVeiculo {
    private Connection conn;
    private java.sql.Statement st;

    private void conectar(){
        try{
            this.conn = ConnectionManager.getConnection();
            st = conn.createStatement();
        } catch(ClassNotFoundException e1){
            System.out.println("Erro ao carregar o driver " + e1.getMessage());
        } catch(SQLException e2){
            System.out.println("Erro ao conectar ao banco de dados " + e2.getMessage());
        }
        
    }

    private void desconectar(){
        try{
            st.close();
            conn.close();
        } catch(SQLException e){
            System.out.println("Erro ao desconectar do banco de dados" + e.getMessage());
        }
    }


    public boolean inserir(Veiculo v){
        boolean resultado = false;
        
        try{
            this.conectar();
            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf = 
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(dt);
            String comando = "INSERT INTO tb_veiculos (modelo, placa, nome, cor, data) VALUES ('" + v.getModelo() + "', '" + v.getPlaca() + "', '" + v.getNome() + "', '" + v.getCor() + "', '" + currentTime + "');";
            System.out.println(comando);
            st.executeUpdate(comando);
            resultado = true;
        } catch(Exception e){
            System.out.println("Erro ao inserir veiculo: " + e.getMessage());
        } finally{
            this.desconectar();
        }
        return resultado;
    }

    public ArrayList<Veiculo> buscarTodos(){
        ArrayList<Veiculo> resultados = new ArrayList<Veiculo>();
        try{
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_veiculos ORDER BY modelo;");
            while(rs.next()){
                Veiculo v = new Veiculo();
                v.setCodigo(rs.getInt("codigo"));
                v.setModelo(rs.getString("modelo"));
                v.setPlaca(rs.getString("placa"));
                v.setNome(rs.getString("nome"));
                v.setCor(rs.getString("cor"));
                v.setData(rs.getDate("data"));
                resultados.add(v);
            }

        } catch(Exception e){
            System.out.println("Erro ao buscar veiculos: " + e.getMessage());
        } finally{
            this.desconectar();
        }
        return resultados;
    }

    public Veiculo buscar(int cod){
        Veiculo v = null;
        try{
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_veiculos WHERE codigo = " + cod + ";");
            if(rs.next()){
                v = new Veiculo();
                v.setCodigo(rs.getInt("codigo"));
                v.setModelo(rs.getString("modelo"));
                v.setPlaca(rs.getString("placa"));
                v.setNome(rs.getString("nome"));
                v.setNome(rs.getString("cor"));
                v.setData(rs.getDate("data"));
            }

        } catch(Exception e){
            System.out.println("Erro ao buscar veiculo: " + e.getMessage());
        } finally{
            this.desconectar();
        }
        return v;
    }

    
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Instrumentos {
    int id;
    String nombre, tipo, foto, caracteristicas; //Foto se va a usar en codigo asci
    double precio;
    /*Constructor*/
    public Instrumentos(int id, String nombre, String tipo, String foto, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.foto = foto;
        this.precio = precio;
        this.caracteristicas = caracteristicas;
    }
    /*constructor vacio*/
    public Instrumentos(){}
    /*Getters y Setters*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String caracteristicas(){
        return caracteristicas;
    }
    public void setCaracteristicas(String caracteristicas){
        this.caracteristicas = caracteristicas;
    }
    public boolean insertaraDB(String nombre, String tipo, double precio, String caracteristicas){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/proyecto", "root", "");
            String sql = "INSERT INTO proyecto(nombre, tipo, precio, caracteristicas ) values (?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, tipo);
                preparedStatement.setDouble(3, precio);
                preparedStatement.setString(4, caracteristicas);
                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas>0) {
                    System.out.println("Ingresado con éxito");
                }
                else {
                    System.out.println("Ingreso fallido");
                }
            }catch (Exception e){
                e.getMessage();
            }
        }catch (Exception exception){
            exception.getMessage();
        }
        return false;
    }
}

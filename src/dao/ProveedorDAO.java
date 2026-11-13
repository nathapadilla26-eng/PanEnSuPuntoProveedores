package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Proveedor;

public class ProveedorDAO {

    // 1. Insertar (Create)
    public boolean crear(Proveedor proveedor) {
        String sql = "INSERT INTO proveedores (nit, razon_social, telefono, correo, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, proveedor.getNit());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getCorreo());
            ps.setBoolean(5, proveedor.isEstado());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar proveedor: " + e.getMessage());
            return false;
        }
    }

    // 2. Consultar (Read)
    public List<Proveedor> listar() {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proveedor p = new Proveedor(
                    rs.getInt("id_proveedor"),
                    rs.getString("nit"),
                    rs.getString("razon_social"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getBoolean("estado")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar proveedores: " + e.getMessage());
        }
        return lista;
    }

    // 3. Actualizar (Update)
    public boolean actualizar(Proveedor proveedor) {
        String sql = "UPDATE proveedores SET nit = ?, razon_social = ?, telefono = ?, correo = ?, estado = ? WHERE id_proveedor = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, proveedor.getNit());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getCorreo());
            ps.setBoolean(5, proveedor.isEstado());
            ps.setInt(6, proveedor.getIdProveedor());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar proveedor: " + e.getMessage());
            return false;
        }
    }

    // 4. Eliminar (Delete)
    public boolean eliminar(int idProveedor) {
        String sql = "DELETE FROM proveedores WHERE id_proveedor = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProveedor);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar proveedor: " + e.getMessage());
            return false;
        }
    }
}
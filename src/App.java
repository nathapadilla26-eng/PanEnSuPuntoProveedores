import dao.ProveedorDAO;
import java.util.List;
import modelo.Proveedor;

public class App {
    public static void main(String[] args) {
        ProveedorDAO dao = new ProveedorDAO();

        // 1. INSERTAR (Create)
        Proveedor prov1 = new Proveedor("900111222-1", "Harinas del Quindio", "3101234567", "ventas@harinasquindio.com", true);
        Proveedor prov2 = new Proveedor("900333444-2", "Lacteos Armenia", "3209876543", "contacto@lacteosarmenia.com", true);

        if (dao.crear(prov1)) {
            System.out.println("1. Proveedor 1 registrado con exito.");
        }
        if (dao.crear(prov2)) {
            System.out.println("1. Proveedor 2 registrado con exito.");
        }

        // 2. CONSULTAR (Read)
        System.out.println("\n--- 2. Lista inicial de proveedores ---");
        List<Proveedor> lista = dao.listar();
        for (Proveedor p : lista) {
            System.out.println("ID: " + p.getIdProveedor() + " | NIT: " + p.getNit() + " | Razon Social: " + p.getRazonSocial() + " | Tel: " + p.getTelefono());
        }

        // 3. ACTUALIZAR (Update) - Modificamos el primer proveedor
        if (!lista.isEmpty()) {
            Proveedor primero = lista.get(0);
            primero.setTelefono("3150000000");
            primero.setRazonSocial("Harinas del Quindio S.A.S");
            if (dao.actualizar(primero)) {
                System.out.println("\n3. Proveedor con ID " + primero.getIdProveedor() + " actualizado con exito.");
            }
        }

        // 4. ELIMINAR (Delete) - Eliminamos el segundo proveedor de prueba
        if (lista.size() >= 2) {
            int idEliminar = lista.get(1).getIdProveedor();
            if (dao.eliminar(idEliminar)) {
                System.out.println("4. Proveedor con ID " + idEliminar + " eliminado con exito.");
            }
        }

        // Consulta final para comprobar los cambios
        System.out.println("\n--- Lista final en base de datos ---");
        for (Proveedor p : dao.listar()) {
            System.out.println("ID: " + p.getIdProveedor() + " | NIT: " + p.getNit() + " | Razon Social: " + p.getRazonSocial() + " | Tel: " + p.getTelefono());
        }
    }
}

package primer_final;

public class Servicio {

    // Atributos adicionales para la clase Servicio
    private int idServicio;
    private String nombreServicio;
    private double costoServicio;

    // Constructor
    public Servicio(int idServicio, String nombreServicio, double costoServicio) {
        // Llamada al constructor de la clase base (PagoServicio)

        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.costoServicio = costoServicio;
    }

    // Métodos getter y setter para Id_servicio
    public int get_IdServicio() {
        return idServicio;
    }

    public void set_IdServicio(int Id_servicio) {
        this.idServicio = Id_servicio;
    }

    // Métodos getter y setter para Nombre_servicio
    public String get_NombreServicio() {
        return nombreServicio;
    }

    public void set_NombreServicio(String Nombre_servicio) {
        this.nombreServicio = Nombre_servicio;
    }

    // Métodos getter y setter para Costo_servicio
    public double get_CostoServicio() {
        return costoServicio;
    }

    public void set_CostoServicio(double Costo_servicio) {
        this.costoServicio = Costo_servicio;
    }
}

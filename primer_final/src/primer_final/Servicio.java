
package primer_final;

public class Servicio {

    private long idServicio;
    private String nombreServicio;
    private double costoServicio;

  
    public Servicio(long idServicio, String nombreServicio, double costoServicio) {
        

        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.costoServicio = costoServicio;
    }

    // Métodos getter y setter para Id_servicio
    public long get_IdServicio() {
        return idServicio;
    }

    public void set_IdServicio(long Id_servicio) {
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

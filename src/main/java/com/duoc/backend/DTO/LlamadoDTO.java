package com.duoc.backend.DTO;

public class LlamadoDTO {
    private String rutUsuario;
    private double latitud;
    private double longitud;

    public String getRutUsuario() { return rutUsuario; }
    public void setRutUsuario(String rutUsuario) { this.rutUsuario = rutUsuario; }

    public double getLatitud() { return latitud; }
    public void setLatitud(double latitud) { this.latitud = latitud; }

    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }
}

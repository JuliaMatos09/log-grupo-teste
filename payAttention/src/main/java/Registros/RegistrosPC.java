package Registros;
public class RegistrosPC {
    private Double usoProcessador;
    private Long memoriaUso;
    private Long discoUso;
    private int dispositivosUSB;
    private Long downloadRede;
    private Integer fkMaquinas;
    public Double getUsoProcessador() {
        return usoProcessador;
    }
    public void setUsoProcessador (Double usoProcessador){
        this.usoProcessador = usoProcessador;
    }
    public Long getMemoriaUso() {
        return memoriaUso;
    }
    public void setMemoriaUso(Long memoriaUso) {
        this.memoriaUso = memoriaUso;
    }
    public Long getDiscoUso() {
        return discoUso;
    }
    public void setDiscoUso(Long discoUso) {
        this.discoUso = discoUso;
    }
    public int getDispositivosUSB() {
        return dispositivosUSB;
    }
    public void setDispositivosUSB(int dispositivosUSB) {
        this.dispositivosUSB = dispositivosUSB;
    }
    public long getDownloadRede() {
        return downloadRede;
    }
    public void setDownloadRede(Long downloadRede) {
        this.downloadRede = downloadRede;
    }
    public Integer getFkMaquinas() {return fkMaquinas;}
    public void setFkMaquinas(Integer fkMaquinas) {this.fkMaquinas = fkMaquinas;}
}

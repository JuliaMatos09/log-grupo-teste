/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registros;
import Conexao.Conexao;
import Maquina.CadastroMaquina;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.util.Conversor;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.sensors.Temperature;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import loginView.LoginView;

/**
 *
 * @author Matheus
 */
public class Captura extends javax.swing.JFrame{
    public static final long TEMPO = (5000);
    static Timer timer = null;
    public void capturaDados() throws SQLException {
        JOptionPane.showMessageDialog(rootPane, "Iniciando a captura de dados em segundo plano...");
         RegistrosPC registros = new RegistrosPC();
         CadastroMaquina cadastroMaquina = new CadastroMaquina();
         /*--------------------------------------------------------------*/

        /*Inicio Looca para captura de dados registro de maquinas*/
        Looca looca = new Looca();
        Memoria memoria = looca.getMemoria();
        DiscoGrupo disco = looca.getGrupoDeDiscos();
        Processador processador = looca.getProcessador();
        if (timer == null) {
            timer = new Timer();
            TimerTask tarefa = new TimerTask() {
                @Override
                public void run() {
                    try {
                            Long memoriaUso = memoria.getEmUso();
                            Long usoDisco = disco.getTamanhoTotal();
                            Long redeDownload = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesRecebidos() / 5;
                            int usbConectados = looca.getDispositivosUsbGrupo().getDispositivosUsbConectados().size();

                            registros.setMemoriaUso(memoriaUso);
                            registros.setUsoProcessador(processador.getUso());
                            registros.setDiscoUso(usoDisco);
                            registros.setDownloadRede(redeDownload);
                            registros.setDispositivosUSB(usbConectados);

                        RegistrosDAO.inserirRegistros(registros);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
        }
    }
}

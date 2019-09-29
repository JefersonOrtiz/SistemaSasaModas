package DAO;

import model.ModelUsuarios;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Jeferson
 */
public class DAOUsuarios extends ConexaoMySql {

    /**
     * grava Usuarios
     *
     * @param pModelUsuarios return int
     */
    public int salvarUsuariosDAO(ModelUsuarios pModelUsuarios) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_usuarios ("
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                    + ") VALUES ("
                    + "'" + pModelUsuarios.getNomeUsuario() + "',"
                    + "'" + pModelUsuarios.getLoginUsuario() + "',"
                    + "'" + pModelUsuarios.getSenhaUsuario() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Usuarios
     *
     * @param pIdUsuario return ModelUsuarios
     */
    public ModelUsuarios getUsuariosDAO(int pIdUsuario) {
        ModelUsuarios modelUsuarios = new ModelUsuarios();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_usuario,"
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                    + " FROM"
                    + " tbl_usuarios"
                    + " WHERE"
                    + " pk_id_usuario = '" + pIdUsuario + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuarios.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuarios.setNomeUsuario(this.getResultSet().getString(2));
                modelUsuarios.setLoginUsuario(this.getResultSet().getString(3));
                modelUsuarios.setSenhaUsuario(this.getResultSet().getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUsuarios;
    }

    /**
     * recupera uma lista de Usuarios return ArrayList
     */
    public ArrayList<ModelUsuarios> getListaUsuariosDAO() {
        ArrayList<ModelUsuarios> listamodelUsuarios = new ArrayList();
        ModelUsuarios modelUsuarios = new ModelUsuarios();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_usuario,"
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                    + " FROM"
                    + " tbl_usuarios"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuarios = new ModelUsuarios();
                modelUsuarios.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuarios.setNomeUsuario(this.getResultSet().getString(2));
                modelUsuarios.setLoginUsuario(this.getResultSet().getString(3));
                modelUsuarios.setSenhaUsuario(this.getResultSet().getString(4));
                listamodelUsuarios.add(modelUsuarios);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelUsuarios;
    }

    /**
     * atualiza Usuarios
     *
     * @param pModelUsuarios return boolean
     */
    public boolean atualizarUsuariosDAO(ModelUsuarios pModelUsuarios) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_usuarios SET "
                    + "pk_id_usuario = '" + pModelUsuarios.getIdUsuario() + "',"
                    + "nome_usuario = '" + pModelUsuarios.getNomeUsuario() + "',"
                    + "login_usuario = '" + pModelUsuarios.getLoginUsuario() + "',"
                    + "senha_usuario = '" + pModelUsuarios.getSenhaUsuario() + "'"
                    + " WHERE "
                    + "pk_id_usuario = '" + pModelUsuarios.getIdUsuario() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Usuarios
     *
     * @param pIdUsuario return boolean
     */
    public boolean excluirUsuariosDAO(int pIdUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_usuarios "
                    + " WHERE "
                    + "pk_id_usuario = '" + pIdUsuario + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    /**
     * Validar login e Senha do usuário
     * @param pModelUsuarios
     * @return 
     */
    public boolean getValidarUsuariosDAO(ModelUsuarios pModelUsuarios) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_usuario,"
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                    + " FROM"
                    + " tbl_usuarios"
                    + " WHERE"
                    + " login_usuario = '" + pModelUsuarios.getLoginUsuario() + "' AND senha_usuario = '" + pModelUsuarios.getSenhaUsuario() + "'"
                    + ";"
            );
            if (getResultSet().next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}

package controller;

import model.ModelUsuarios;
import DAO.DAOUsuarios;
import java.util.ArrayList;

/**
*
* @author Jeferson
*/
public class ControllerUsuarios {

    private DAOUsuarios daoUsuarios = new DAOUsuarios();

    /**
    * grava Usuarios
    * @param pModelUsuarios
    * return int
    */
    public int salvarUsuariosController(ModelUsuarios pModelUsuarios){
        return this.daoUsuarios.salvarUsuariosDAO(pModelUsuarios);
    }

    /**
    * recupera Usuarios
    * @param pIdUsuario
    * return ModelUsuarios
    */
    public ModelUsuarios getUsuariosController(int pIdUsuario){
        return this.daoUsuarios.getUsuariosDAO(pIdUsuario);
    }

    /**
    * recupera uma lista deUsuarios
    * @param pIdUsuario
    * return ArrayList
    */
    public ArrayList<ModelUsuarios> getListaUsuariosController(){
        return this.daoUsuarios.getListaUsuariosDAO();
    }

    /**
    * atualiza Usuarios
    * @param pModelUsuarios
    * return boolean
    */
    public boolean atualizarUsuariosController(ModelUsuarios pModelUsuarios){
        return this.daoUsuarios.atualizarUsuariosDAO(pModelUsuarios);
    }

    /**
    * exclui Usuarios
    * @param pIdUsuario
    * return boolean
    */
    public boolean excluirUsuariosController(int pIdUsuario){
        return this.daoUsuarios.excluirUsuariosDAO(pIdUsuario);
    }
}
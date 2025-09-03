package com.sysDevCom.SERVICECTRLUSER.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sysDevCom.SERVICECTRLUSER.DTO.CtrlUsersDTO;
import com.sysDevCom.SERVICECTRLUSER.Model.CtrlUsers;
import com.sysDevCom.SERVICECTRLUSER.Repository.CtrlUsersRepository;

@Service
public class CtrlUsersService {
    private final CtrlUsersRepository ctrlUsersRepository;
   
    public CtrlUsersService(CtrlUsersRepository repository) {
        this.ctrlUsersRepository = repository;
    }
   
    //Obtiene una lista completa de usuarios registrados ala bd
    public List<CtrlUsersDTO> getAll() {
    return ctrlUsersRepository.findAll().stream().map(u -> new CtrlUsersDTO(u.getId(),u.getUserName(),u.getclvPass(),u.getemailUser(),u.getNombres(),u.getaPaterno(),u.getaMaterno(),u.getFecRegistro())).toList();
    }

    // Inserta al usuario en la bd, listo para usarse en el login
    public CtrlUsers crearUsuario(CtrlUsers usuario) {
        return ctrlUsersRepository.save(usuario);
    }

    // Actualizar usuario
    public CtrlUsers actualizarUsuario(CtrlUsers usuario) {
        if (usuario.getId() == null || usuario.getId().isEmpty()) {
            throw new IllegalArgumentException("El id no puede ser null para actualizar");
        }

        // Busca si existe el usuario
        CtrlUsers existente = ctrlUsersRepository.findById(usuario.getId()).orElseThrow(() -> new IllegalArgumentException("Usuario con id " + usuario.getId() + " no existe"));
        existente.setUserName(usuario.getUserName());
        existente.setclvPass(usuario.getclvPass());
        existente.setemailUser(usuario.getemailUser());
        existente.setNombres(usuario.getNombres());
        existente.setaPaterno(usuario.getaPaterno());
        existente.setaMaterno(usuario.getaMaterno());

        return ctrlUsersRepository.save(existente);
    }
    // Listar todos los usuarios
    public List<CtrlUsers> listarUsuarios(){
        return ctrlUsersRepository.findAll();
    }

    // Eliminar usuario por id
    public void eliminarUsuario(String id) {
    CtrlUsers usuario = ctrlUsersRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Usuario con id " + id + " no existe"));
    ctrlUsersRepository.delete(usuario);
    }

    //Servicio para mostrar caracteristicas del servicio rest
    public String infoServicio() {
        return "Servicio REST para la gestion de usuarios. Servicio desarrollado por SysDevCom. Realiza un monitoreo de usuarios a nivel administrativo.";
    }

}
    
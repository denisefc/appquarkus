package br.edu.infnet.controller;

import br.edu.infnet.model.Usuario;
import br.edu.infnet.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @POST
    @Transactional
    public Response criarUsuario(Usuario usuario) {
        return Response.ok(usuarioService.criarUsuario(usuario)).build();
    }
    @GET
    public Response findAll(){
        return Response.ok(usuarioService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long idUsuario) {
        return Response.ok(usuarioService.findById(idUsuario)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarUsuario(@PathParam("id") Long idUsuario, Usuario usuario) {
        return Response.ok(usuarioService.atualizarUsuario(idUsuario, usuario)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long idUsuario) {
        usuarioService.deleteById(idUsuario);
        return Response.noContent().build();
    }

}

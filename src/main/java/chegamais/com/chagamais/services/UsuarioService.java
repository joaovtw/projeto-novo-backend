package chegamais.com.chagamais.services;

import java.util.List;
import java.util.Optional;
import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chegamais.com.chagamais.controller.DTO.UsuarioDTO;
import chegamais.com.chagamais.model.Usuario;
import chegamais.com.chagamais.repository.UsuarioRepository;

public class UsuarioService implements ServiceInteface<UsuarioDTO> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> obterTodos() {
        // TODO Auto-generated method stub

        List<Usuario> usuarios = usuarioRepository.findAll();

        return this.converterLista(usuarios);
    }

    @Override
    public UsuarioDTO obterPorId(Long id) {
        // TODO Auto-generated method stub

        Optional<Usuario> usuarioOp = usuarioRepository.findById(id);

        return this.converterOptional(usuarioOp, false);
    }

    @Override
    public UsuarioDTO adicionar(UsuarioDTO dto) {
        // TODO Auto-generated method stub

        dto.setId(null);


        Usuario usuario = dto.converterParaModel();

        usuarioRepository.save(usuario);
        dto.setId(usuario.getId());

        return dto;
    }

    @Override
    public UsuarioDTO atualizar(UsuarioDTO dto, Long id) {
        // TODO Auto-generated method stub

        Optional<Usuario> usuarioOp = usuarioRepository.findById(id);

        Usuario usuario = usuarioOp.get();

        this.verificarEAtualizar(usuario, dto);

        usuarioRepository.save(usuario);
        
        dto = this.converterModelParaDTO(usuario);
        dto.setId(usuario.getId());


        return dto;
    }

    @Override
    public UsuarioDTO deletarPorId(Long id) {
        // TODO Auto-generated method stub

        Optional<Usuario> usuarioOp = usuarioRepository.findById(id);

        if(!usuarioOp.isPresent()){
            return null;
        }

        UsuarioDTO usuarioDTO = this.converterOptional(usuarioOp, true);

        usuarioRepository.deleteById(id);

        return usuarioDTO;
    }


    //funcoes auxiliares

    private UsuarioDTO converterModelParaDTO(Usuario usuario){
        return new  UsuarioDTO(usuario.getNome(), usuario.getDataNascimento(), 
        usuario.getPosicaoFavorita(), usuario.getEmail(), usuario.getSenha());

    }

    private List<UsuarioDTO> converterLista(List<Usuario> usuarios){
    	List<UsuarioDTO> DTOs = new ArrayList<UsuarioDTO>();
    	
    	for(Usuario usuario: usuarios) {
    		UsuarioDTO dto = this.converterModelParaDTO(usuario);
    		DTOs.add( dto);
    	}
    	
    	return DTOs;
    	
    }

    private UsuarioDTO converterOptional(Optional<Usuario> usuarioOp, Boolean confere){

        if(!confere){
        if(!usuarioOp.isPresent()){
            return null;
        }
    }

        Usuario usuario = usuarioOp.get();
        UsuarioDTO dto = this.converterModelParaDTO(usuario);


        return dto;

    }

    private void verificarEAtualizar(Usuario usuario, UsuarioDTO usuarioDTO){

        String nomeDTO = usuarioDTO.getNome();
        if(nomeDTO != null ){
            if(nomeDTO != ""){
                usuario.setNome(nomeDTO);
            }
        }

        String emailDTO = usuarioDTO.getEmail();
        if(emailDTO != null ){
            if(emailDTO != ""){
                usuario.setEmail(emailDTO);
            }
        }

        String senhaDTO = usuarioDTO.getSenha();
        if(senhaDTO != null){
            if(senhaDTO != ""){
                usuario.setSenha(senhaDTO);
            }
        }

        String posicaoDTO = usuarioDTO.getPosicaoFavorita();
        if(posicaoDTO != null){
            if(posicaoDTO != ""){
                usuario.setPosicaoFavorita(posicaoDTO);;
            }
        }
        
        Date dataNascimentoDTO = usuarioDTO.getDataNascimento();
        if(dataNascimentoDTO != null){
            usuario.setDataNascimento(dataNascimentoDTO);

        }

    }

    

    

    

   
    
}

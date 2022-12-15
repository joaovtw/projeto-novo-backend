package chegamais.com.chagamais.services;

import java.util.List;

public interface ServiceInteface<T> {

    public List<T> obterTodos();

    public T obterPorId(Long id);

    public T adicionar(T dto);

    public T atualizar(T dto, Long id);

    public T deletarPorId(Long id);
    
}

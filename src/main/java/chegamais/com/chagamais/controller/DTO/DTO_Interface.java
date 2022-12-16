package chegamais.com.chagamais.controller.DTO;

public interface DTO_Interface<T, K> {

    public T converterParaModel();

    public K converterParaResponse();
    
}

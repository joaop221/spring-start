package br.com.joaop221.helloworld.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção de aplicação. Indica que algum objeto não foi encontrado. Ao ser
 * lançada na camada controller, causa retorno de erro 204 (Not Found), conforme
 * definido pela anotação @ResponseStatus.
 */
@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoContentException extends RuntimeException {
    /**
     * Id de Serialização
     */
    private static final long serialVersionUID = -6754767023122935455L;

    public NoContentException(String message) {
        super(message);
    }

    public NoContentException(String message, Throwable e) {
        super(message, e);
    }
}

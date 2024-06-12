package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.exception.ErroConexaoApiException;
import net.suuft.libretranslate.Language;
import net.suuft.libretranslate.Translator;
import net.suuft.libretranslate.exception.BadTranslatorResponseException;

public class ConsultaLibreTranslate {
    public static String obterTraducao(String texto) throws ErroConexaoApiException, RuntimeException, BadTranslatorResponseException {
        String resposta;
        Translator.setUrlApi("https://libretranslate.de/translate");
        resposta = Translator.translate(Language.ENGLISH, Language.PORTUGUESE, texto);
        if (resposta == null || resposta.isEmpty()) {
            throw new ErroConexaoApiException("Erro de Conexão");
        }
        return resposta;
    }
}

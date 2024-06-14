package com.example;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.util.Scanner;
import static java.time.Duration.ofSeconds;

public class Configuracoes {

    public static void main(String[] args) {


        ChatLanguageModel LLM = OpenAiChatModel.builder()
                .apiKey("lm-studio")
                .baseUrl("http://localhost:1234/v1")
                .modelName("TheBloke/sqlcoder-7B-GGUF/sqlcoder-7b.Q4_K_M.gguf")
                .temperature(0.7)
                .timeout(ofSeconds(300))
                .build();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Pergunta: ");
                String pergunta = scanner.nextLine();


                String resposta = LLM.generate(pergunta);

                System.out.println(resposta);
            }
        }
    }
}
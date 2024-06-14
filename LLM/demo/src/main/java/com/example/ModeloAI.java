package com.example;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.StreamingResponseHandler;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.model.output.Response;

public class ModeloAI {

    public static void main(String[] args) {

        OpenAiStreamingChatModel modelo = OpenAiStreamingChatModel.withApiKey("lm-studio");

        String sugestaoLLM = "Write an SQL Query based on the prompt";

        System.out.println("Nr of chars: " + sugestaoLLM.length());
        System.out.println("Nr of tokens: " + modelo.estimateTokenCount(sugestaoLLM));

        modelo.generate(sugestaoLLM, new StreamingResponseHandler<AiMessage>() {

            @Override
            public void onNext(String token) {
                System.out.print(token);
            }

            @Override
            public void onComplete(Response<AiMessage> response) {
                System.out.println("\n\nDone streaming");
            }

            @Override
            public void onError(Throwable error) {
                System.out.println("Something went wrong: " + error.getMessage());
            }
        });

    }
}
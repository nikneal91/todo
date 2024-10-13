package com.example.dp;

public class PromiseUtil {

    private void promiseUsage() {
        calculateLineCount();
        calculateLowestFrequencyChar();
      }
    
      private void calculateLowestFrequencyChar() {
        // Create a promise to calculate the lowest frequency character
        lowestFrequencyChar().thenAccept(
            charFrequency -> {
              LOGGER.info("Char with lowest frequency is: {}", charFrequency);
            }
        );
      }
    
      private void calculateLineCount() {
        // Create a promise to calculate the line count
        countLines().thenAccept(
            count -> {
              LOGGER.info("Line count is: {}", count);
            }
        );
      }
    
      private Promise<Character> lowestFrequencyChar() {
        // Create a promise to calculate the character frequency and then find the lowest frequency character
        return characterFrequency().thenApply(Utility::lowestFrequencyChar);
      }
    
      private Promise<Map<Character, Long>> characterFrequency() {
        // Create a promise to download a file and then calculate the character frequency
        return download(DEFAULT_URL).thenApply(Utility::characterFrequency);
      }
    
      private Promise<Integer> countLines() {
        // Create a promise to download a file and then count the lines
        return download(DEFAULT_URL).thenApply(Utility::countLines);
      }
    
      private Promise<String> download(String urlString) {
        // Create a promise to download a file
        return new Promise<String>()
            .fulfillInAsync(
                () -> Utility.downloadFile(urlString), executor)
            .onError(
                throwable -> {
                  LOGGER.error("An error occurred: ", throwable);
                }
            );
      }
    }

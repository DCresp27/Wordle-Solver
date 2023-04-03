package edu.touro.cs.mcon364;

class WordleResponse
{
    char c;
    int index;
    LetterResponse resp;

    public WordleResponse(char c, int index, LetterResponse resp) {
        this.c = c;
        this.index = index;
        this.resp = resp;
    }
}


enum LetterResponse {
    CORRECT_LOCATION, // Green
    WRONG_LOCATION,   // Yellow
    WRONG_LETTER }    // Gray

/*
if users guesses "TRAIN" (and target is "SHLEP") response would be 5 WordleResponses,
first would be a WordleReponse object with the following values
c='T'
index = 0
LetterResponse = LetterResponse.WRONG_LETTER
 */



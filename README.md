# QamarKeez
A text editor that focuses mainly on the keyboard for user interactions and accessing options.\
**Technology**: data structures like BST, tries and HashMaps and JavaFX for the frontend.

## Features:
- Generate text
  - The app takes user input text, cut it into tokens, map each token to a LinkedList of possible words that can exist after that token in the input text.
  - The possible words are entered more than once if necessary to maintain their frequency. Frequency is what we will use to generate text later.
  - Why LinkedList and not an ArrayList? Because LinkedList has faster insert/delete runtimes. You just traverse towards the node you want and then do your operation.
  - While in the ArrayList have to insert a new element at position i, you have to swap all elements from i+1 to end of the array.
  - Array is not big enough? Now we have to create a whole new array and copy the old array to it. That’s a lot of work for a single insertion operation.

- Autocomplete
  - Here we essentially store the english words saved from a say text file into memory. Then as the user types in the editor, the app takes the last word as a prefix
  - into getPossibleWords(String prefix, int countWords) method. The method searches 466k words to find all words that starts with this prefix.
  - but stops searching when countWords limit is reached. I typically generate 10 words.
  - The app can generate +50k word in 0.079s (0.049 on average).
  - Words in words.txt was mixed case. But I rewrote the file using BufferedWriter to lowercase the words.

- Flesch score
  - Is an equation that roughly measures how complex a text is.\
    ![equation](http://www.sciweavers.org/tex2img.php?eq=%24206.835-1.015%28%5Cdfrac%7Bnum~words%7D%7Bnum~sentences%7D%29-84.6%28%5Cdfrac%7Bnum~syllables%7D%7Bnum~words%7D%29%24&bc=White&fc=Black&im=jpg&fs=12&ff=arev&edit=0) 

    Basically we start with score (206.835) that when is large, the text is more readable, as number of words per sentence or number of syllables per words increase,
    this score decreases by weights of these ratios. Equation was developed by author Rudolf Flesch if you are interested.

## Copyrights
- words.txt data is from
https://github.com/dwyl/english-words. Originally from Infochimps
- Some backend files are removed because they may include solutions to an online course.
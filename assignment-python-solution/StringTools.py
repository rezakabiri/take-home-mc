from collections import namedtuple
from test_ import utilities
from timeit import default_timer as timer
import timeit


class StringTools():

    def __init__(self):
        pass


def find_longest_word_and_length(input_string):

    if type("") != type(input_string):
        raise ValueError("input must be string")

    input_string = input_string.replace("[^A-Za-z0-9 ]", " ")
    input_string_list = input_string.split(" ")

    result = namedtuple("result", "len word")
    result.len = -1
    result.word = ""

    for word in input_string_list:

        len_word = len(word)

        if len_word > result.len and len_word:
            result.len = len_word
            result.word = word.lower()

    if result.len < 1:
        raise ValueError("input should consist of at least one alphanumeric character")

    return result

if __name__ == "__main__":

    result = find_longest_word_and_length("jumped the foxy fox")
    print("{len} and {word}".format(len=result.len, word=result.word))

    shakes_text = utilities.read_big_text_from_resource("shakespear.txt")
    start = timer()
    find_longest_word_and_length(shakes_text)
    end = timer()
    print("shakespear time is {}".format(end - start))

    max_iter = 500
    start = timer()
    for _ in range(500):
        find_longest_word_and_length("The cow jumped over the moon.")
    end = timer()
    print(str(max_iter) + " times time is {}".format(end - start))



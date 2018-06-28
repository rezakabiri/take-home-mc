import StringTools
import unittest
from collections import namedtuple
from test_ import utilities
from timeit import default_timer as timer


class TestStringTools(unittest.TestCase):

    def get_result_tuple(self, len=-1, word=""):

        result = namedtuple("result", "len word")
        result.len = len
        result.word = word
        return result

    def assert_reults_are_same(self, expected_result, actual_result):

        self.assertEquals(expected_result.len, actual_result.len)
        self.assertEquals(expected_result.word, actual_result.word)

    def test_given_non_string_input_then_raise_exception(self):

        un_allowed_input = 1

        with self.assertRaises(ValueError) as context:
            StringTools.find_longest_word_and_length(un_allowed_input)

        self.assertTrue("input must be string" in str(context.exception))

    def test_given_one_char_string_then_1_same_string(self):

        one_char_string = "a"

        expected_result = self.get_result_tuple(len=1, word="a")
        actual_result = StringTools.find_longest_word_and_length(one_char_string)

        self.assert_reults_are_same(expected_result, actual_result)

    def test_given_one_word_string_then_1_same_string(self):

        one_word_string = "abcd "

        expected_result = self.get_result_tuple(len=4, word="abcd")
        actual_result = StringTools.find_longest_word_and_length(one_word_string)

        self.assert_reults_are_same(expected_result, actual_result)

    def given_the_cow_jumped_over_moon_then_return_6_jumped(self):

        input_string = "the cow jumped over the moon."

        expected_result = self.get_result_tuple(len=6, word="jumped")
        actual_result = StringTools.find_longest_word_and_length(input_string)

        self.assert_reults_are_same(expected_result, actual_result)

    def test_method_should_return_first_longet_word(self):
        input_string = "the cow overai jumped the moon."

        expected_result = self.get_result_tuple(len=6, word="overai")
        actual_result = StringTools.find_longest_word_and_length(input_string)

        self.assert_reults_are_same(expected_result, actual_result)

    def test_given_permutaion_of_one_sentence_then_resutls_should_be_same(self):

        input_1 = "the cow jumped over the moon."
        input_2 = "the jumped over the cow moon."

        result_1 = StringTools.find_longest_word_and_length(input_1)
        result_2 = StringTools.find_longest_word_and_length(input_2)

        self.assert_reults_are_same(result_1, result_2)

    def test_method_will_always_return_lowercase(self):
        input_string = "the cow JUMPED over the moon."

        expected_result = self.get_result_tuple(len=6, word="jumped")
        actual_result = StringTools.find_longest_word_and_length(input_string)

        self.assert_reults_are_same(expected_result, actual_result)

    def given_empty_string_then_throw_exception(self):
        un_allowed_input = ""

        with self.assertRaises(ValueError) as context:
            StringTools.find_longest_word_and_length(un_allowed_input)

        self.assertTrue("input should consist of at least one alphanumeric character" in str(context.exception))

    def given_shakespear_text_then_it_should_take_less_than_50ms(self):

        shakes_text = utilities.read_big_text_from_resource("shakespear.txt")

        start = timer()
        StringTools.find_longest_word_and_length(shakes_text)
        end = timer()

        self.assertTrue((end - start) < 0.005)

if __name__ == "__main__":
    unittest.main()

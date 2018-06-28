import io
import os

def read_big_text_from_resource(file_name):

    this_dir = os.path.dirname(__file__)
    path_to_file = this_dir + "/resources/" + file_name

    read_string = io.StringIO()

    with open(path_to_file) as file:

        for line_ in file.readlines():
            read_string.write(line_)

    read_string = read_string.getvalue()
    return read_string

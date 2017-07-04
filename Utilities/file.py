# This is a utility to create html files from a template used for holding
# the text of the book.

import os
import shutil

# Read in the list of filenames to create from 'list.txt'
with open('list.txt') as f:
    lines = f.read().splitlines()

# Identify the name of the template file to be duplicated and it's destination.
template_file = 'template.html'
dest_folder = 'home'

assert not os.path.isabs(srcfile)

# Loop through each file name and create it's corresponding html file.
for i in lines:
    dstdir = os.path.join(dest_folder, i)
    shutil.copy(template_file, dstdir)

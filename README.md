# Encoder

## Requirements

The encoder app should take the following input:
* a path to a file
* encryption key

It should produce the following output file with the encoded data (see format below)


## Input File Format

The input file will be a .csv

Columns
* username
* password (if blank, generate a password)

## Output File Format

The input file will be a .csv

Columns
* username
* base64 encoded password
* encrypted password


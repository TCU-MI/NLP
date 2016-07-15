#!/bin/bash

# Running MainConText
#
# NOTE 1: Runs on Linux
# NOTE 2: As we did not have access to Gold Standard annotations for Temporality and Experiencer we used the Annotations-1-120-random.txt
#         file. However, that file has annotations for negation only. This is a clear limitation for the evaluation of the performance of
#         GenTemporality and GenExperiencer modules. (Imre Solti) 
#
java MainConText Annotations-1-120-random.txt yes


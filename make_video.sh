#!/bin/bash
ffmpeg -r 30 -pattern_type glob -i 'images/*.png' -vcodec libx264 -crf 25  -pix_fmt yuv420p output.mp4

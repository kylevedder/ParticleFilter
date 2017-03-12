#!/usr/bin/env python3

import matplotlib.pyplot as plt
import matplotlib.animation as animation
import numpy as np
import sys
import math
import pdb

class bcolors:
    HEADER = '\033[95m'
    OKBLUE = '\033[94m'
    OKGREEN = '\033[92m'
    WARNING = '\033[93m'
    FAIL = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'

def extract_tuple(p_str):
    first_comma = p_str.find(',')
    p_x = p_str[0:first_comma]
    p_y = p_str[first_comma + 1:]
    return (p_x, p_y)

if __name__ == "__main__":
    print ("Starting visualizer")
    fig, ax = plt.subplots()

    with open(sys.argv[1], 'r') as openfileobject:
        for line in openfileobject:
            #print line
            # Format x1, y1, x2, y2

            first_comma = line.find(',')
            second_comma = line[first_comma + 1:].find(',') + first_comma
            p1_str = line[0:second_comma + 1]
            p2_str = line[second_comma + 2:]

            p1_tuple = extract_tuple(p1_str)
            p2_tuple = extract_tuple(p2_str)

            print ("P1: " + p1_tuple[0] + ", " + p1_tuple[1])
            print ("P2: " + p2_tuple[0] + ", " + p2_tuple[1])

            plt.plot([p1_tuple[0],p2_tuple[0]],[p1_tuple[1],p2_tuple[1]],
                     linestyle='solid', color='black')

    update_list = []
    with open(sys.argv[2], 'r') as particles:
        i = 0
        for line in particles:
            if i >= 0:
                line_data_list = []
                splitLine = line.split(" ")
                numelems = int(splitLine[0])
                splitLine.pop(0)
                # print("Num Particles: " + str(numelems))
                prev_particles = []
                x_pos = []
                y_pos = []
                theta_pos = []
                weights = []
                for item in range(0, numelems):
                    x = float(splitLine[5*item])
                    y = float(splitLine[5*item + 1])
                    theta = float(splitLine[5*item + 2])
                    nonnornweight = float(splitLine[5*item + 3])
                    weight = float(splitLine[5*item + 4])
                    # print("X: " + str(x) + " Y: " + str(y) + " Theta: " + str(theta) +
                    #       " NN Weight: " + str(nonnornweight) + " \nWeight: " + str(weight))
                    prev_particles.append(ax.scatter(x, y, color='black', alpha=weight**3))
                    plt.plot([x, x + 0.1 * math.cos(theta)],
                             [y, y + 0.1*math.sin(theta)],
                             alpha=weight)
                    x_pos.append(x)
                    y_pos.append(y)
                    theta_pos.append(theta)
                    weights.append(weight)

                average_x = np.average(x_pos, weights=weights)
                average_y = np.average(y_pos, weights=weights)
                average_theta = np.average(theta_pos, weights=weights)
                ax.set_xlim([average_x - 2, average_x + 2])
                ax.set_ylim([average_y - 2, average_y + 2])
                circ = plt.Circle((average_x,average_y), radius=0.05, color='r', fill=False)
                arr = plt.arrow(average_x, average_y, 0.2*math.cos(theta),
                                0.2*math.sin(theta), head_width=0.05,
                                head_length=0.1, fc='k', ec='k')
                ax.add_artist(circ)
                print(str(i) + " Avg: " + str(average_x) + ", " + str(average_y))
                plt.savefig('//home/kyle/code/603/ParticleFilter/images/frame_{num:05d}.png'
                            .format(num=i))
                # Blocks until gets a keyboard press
                # if i % 20 == 0:
                #     print (bcolors.UNDERLINE + bcolors.BOLD + bcolors.HEADER + "Waiting for human input!" + bcolors.ENDC)
                #     while not plt.waitforbuttonpress():
                #         print ("Mouse Press")
                # else:
                #     plt.pause(0.000001)

                for item in range(0, numelems):
                    del(ax.lines[-1])
                    prev_particles[item].remove()
                circ.remove()
                arr.remove()

                # print(str(line_data_list))
                update_list.append(line_data_list)
            i = i + 1

    print ("Out of data!")
    plt.show()

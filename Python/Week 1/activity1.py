#!/usr/bin/python

def findMinMax(temperatures):
    max_value = temperatures[0]
    min_value = temperatures[0]

    for i in range(len(temperatures)):
        if temperatures[i] > max_value:
            max_value = temperatures[i]
        if temperatures[i] < min_value:
            min_value = temperatures[i]

    return max_value, min_value


def main():
    temperatures = [22, 30, 25, 28, 35, 31, 27]
    values = findMinMax(temperatures)
    print("Max Temperature: {}°C, Min Temperature: {}°C".format(
        values[0], values[1]))


if __name__ == '__main__':
    main()

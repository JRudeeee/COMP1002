#!/usr/bin/python

import csv

DAYS = 365


def main():
    # specify path to temperature csv
    filePath = "Python\Week 1\\temperatures_365_days.csv"

    # initialise all dates slots for year
    dates = [None] * DAYS

    # initialise all temperature slots for year
    temperatures = [0] * DAYS

    readTemperatureData(filePath, dates, temperatures)
    findExtremeDates(dates, temperatures)

    print("Hottest day: {} with temperature {}°C".format(maxDay, maxTemp))
    print("Coldest day: {} with temperature {}°C".format(minDay, minTemp))


def readTemperatureData(filePath, dates, temperatures):
    with open(filePath) as csvDataFile:
        reader = csv.reader(csvDataFile)
        next(reader)
        i = 0
        for row in reader:
            dates[i] = row[0]
            temperatures[i] = row[1]
            i = i + 1
    csvDataFile.close


def findExtremeDates(dates, temperatures):
    global maxTemp
    maxTemp = temperatures[0]
    global minTemp
    minTemp = temperatures[0]
    global maxDay
    maxDay = dates[0]
    global minDay
    minDay = dates[0]

    for i in range(1, DAYS-1):
        if temperatures[i] > maxTemp:
            maxTemp = temperatures[i]
            maxDay = dates[i]
        if temperatures[i] < minTemp:
            minTemp = temperatures[i]
            minDay = dates[i]
    print("Hottest day: {} with temperature {}°C".format(maxDay, maxTemp))
    print("Coldest day: {} with temperature {}°C".format(minDay, minTemp))


if __name__ == '__main__':
    main()

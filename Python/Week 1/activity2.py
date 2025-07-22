#!/usr/bin/python

import csv

DAYS = 365  # days of the year

# Main method, run with if statement at end of file


def main():
    # specify path to temperature csv
    filePath = "Python\Week 1\\temperatures_365_days.csv"

    # initialise all dates slots for year
    dates = [None] * DAYS

    # initialise all temperature slots for year
    temperatures = [0] * DAYS

    # read temperature data into arrays
    readTemperatureData(filePath, dates, temperatures)

    # find the hottest and coldest days
    findExtremeDates(dates, temperatures)

    # display the results
    print("Hottest day: {} with temperature {}°C".format(maxDay, maxTemp))
    print("Coldest day: {} with temperature {}°C".format(minDay, minTemp))


# Method reads temperature data from a CSV file and stores the data into the
# supplied arrays
# Inputs |  filePath - location of CSV file
#        |  dates - String array to store date
#        |  temperatures - number array to store temp data
def readTemperatureData(filePath, dates, temperatures):
    # open csv file
    with open(filePath) as csvDataFile:
        # attach reader to csv file
        reader = csv.reader(csvDataFile)
        # discard first line
        next(reader)
        i = 0
        # itterate through csv file store dates and temperatures to associated
        # arrays
        for row in reader:
            dates[i] = row[0]
            temperatures[i] = row[1]
            i = i + 1
    # close csv file
    csvDataFile.close


# Method find the highest and lowest temperatures in the supplied arrays
# Inputs |  dates - array of date
#        |  temperatures - array of temperatures
def findExtremeDates(dates, temperatures):
    # set max/min temp and day to start of associated arrays. Variables global
    # for use in main()
    global maxTemp
    maxTemp = temperatures[0]
    global minTemp
    minTemp = temperatures[0]
    global maxDay
    maxDay = dates[0]
    global minDay
    minDay = dates[0]

    # itterate through remaining days in arrays
    for i in range(1, DAYS-1):
        # check if index is higher than the current max, update max if true
        if temperatures[i] > maxTemp:
            maxTemp = temperatures[i]
            maxDay = dates[i]
        # check if index is lower than the current min, update min if true
        if temperatures[i] < minTemp:
            minTemp = temperatures[i]
            minDay = dates[i]
    # display the results
    print("Hottest day: {} with temperature {}°C".format(maxDay, maxTemp))
    print("Coldest day: {} with temperature {}°C".format(minDay, minTemp))


# if main() method exists, run it
if __name__ == '__main__':
    main()

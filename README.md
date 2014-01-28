TripMapper
==========

An intelligent Java application that summarizes geocodes. 

This is a submission to Microsoft Softcoding event conducted during Kurukshetra 2014.

The following is the problem statement for which the app is built.

Problem Statement
===================
You are given a long list of tuples which indicate the time trail of a person who was on a holiday trip. This data is given at 5 minute granularity for the entire trip. Your program should use this data to figure out what activities the user was performing through the trip. The various user ‘activities’ to figure out are as follows
Starting and ending markers: TRIP_START, TRIP_END
Travel related: WALK, BUS_TRAVEL, TAXI_TRAVEL, TRAIN_TRAVEL, FLIGHT_TRAVEL, BOAT_TRAVEL
Activity related: HOTEL_STAY, BREAKFAST, LUNCH, DINNER, COFFEE, TOURIST_SPOT, SHOPPING
Anything other than the above: OTHER
The program needs to output a file which is list of tuples [one tuple per line] where
Latitude – refers to the latitude of the location where the activity started
Longitude – refers to the longitude of the location where the activity started
Activity – refers to any activity listed above
StartTime – refers to the start time of the activity
TimeSpent – refers to the duration (in minutes) of the activity
Comment – this is a free form text field for you to add any additional information about the activity. Let’s say, the restaurant name where the person had his/her lunch etc. If there is no additional information, you can output the string “NONE” to this field.
The trip will not exceed 5 days. Hence, the maximum # of rows in the input file is 5 * 24 * 12 = 1,440 
Your program does not have to produce one line of output for each line of input in the input file. Whenever the user location does not change (like night stay in a hotel etc.)  (OR) if the change in location/time does not indicate any significant action change (like traveling by bus etc.), you can club several rows in the input into a single output row.
Important Note: There is no ‘perfect solution’ for this problem since the output is dependent on how much you can infer from the location data of the trip. The idea is to infer as much rich information as you can from just the location data.

Schema of input file

<Latitude>,<Longitude>,<Time>

Example:
========
12.966101,77.596354,12/26/2013 7:00 PM
12.965019,77.598676,12/26/2013 7:05 PM
12.965678,77.602893,12/26/2013 7:10 PM
12.967915,77.590393,12/26/2013 7:15 PM
12.969431,77.589158,12/26/2013 7:20 PM
12.971522,77.590767,12/26/2013 7:25 PM
12.972149,77.592162,12/26/2013 7:30 PM
12.972296,77.592655,12/26/2013 7:35 PM
12.972421,77.593621,12/26/2013 7:40 PM

Schema of output file

<Latitude>,<Longitude>,<Activity>,<StartTime>,<TimeSpent>,<Comment>

For the input above, one of the valid solution output files could be as follows:
================================================================================
12.966101,77.596354,TRIP_START,12/26/2013 7:00 PM,0,Microsoft Building
12.966101,77.596354,WALK,12/26/2013 7:00 PM,10,Walk to Richmond Road Bus Stop
12.965678,77.602893,BUS_TRAVEL,12/26/2013 7:10 PM,5,Richmond Road to Corporation Bus Stop
12.967915,77.590393,WALK,12/26/2013 7:15 PM,5,Walk to Cubbon Park
12.969431,77.589158,TOURIST_SPOT,12/26/2013 7:20 PM,20,Cubbon Park
12.972421,77.593621,TRIP_END,12/26/2013 7:40 PM,0,Cubbon Park

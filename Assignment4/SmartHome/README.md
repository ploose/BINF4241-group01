#Some remarks:
To simplify the implementation of the project we decided to make the following alterations to the command pattern:
- Client and Invoker are summed up into the smartphone class
- Receiver and ConcreteCommand are summed up into the realizations of the specific command interfaces

Apart from the (slightly modified) command pattern we also used the singleton pattern for the smart-devices, as we
thought that it would be likely, that there is only one of each appliances (except you really would like to have an
army of cleaning robots).

Also we assume that the user input is as expected (i.e. time and temperature are integers) and that the values are 
in a rational range (i.e. not setting the oven to 1 billion degrees).

Furthermore only valid menu-options are shown. So if the start function is not listed, this means that you probably have
to input at least one more required parameter.
#classes:
- Smartphone (singleton)
- Oven (singleton)
- Microwave (singleton)
- Dishwasher (singleton)
- WashingMachine (singleton)
- CleaningRobot (singleton, runnable)
- Command (interface)
- IOven (interface)
- IMicrowave (interface)
- IDishwasher (interface)
- IWashingMachine (interface)
- ICleaningRobot (interface)
- TimerThread (runnable)
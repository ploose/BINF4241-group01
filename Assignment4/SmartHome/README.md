#Some remarks:
To simplify the implementation of the project we decided to make the following alterations to the command pattern:
- Client and Invoker are summed up into the smartphone class
- Receiver and ConcreteCommand are summed up into the realizations of the specific command interfaces

Apart from the (slightly modified) command pattern we also used the singleton pattern for the smart-devices, as we
thought that it would be likely, that there is only one of each appliances (except you really would like to have an
army of cleaning robots).
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
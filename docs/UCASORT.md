Usage
=====

This module uses Java RuleBasedCollator to sort using custom rules.

### Note :
This module is still under development and this document presently shows only currently available utilities.

#### Sorting 
```
        
        String text = ...;
        String[] arr = UCASort.sort(text);      
         
         or
        
        TextView tv1 = ... ;
        String[] arr = UCASort.sort(tv1);      
```

#### Get module name and information
```

        String moduleName = UCASort.getModuleName();
        String moduleInforamtion =  UCASort.getModuleInformation();
```

#### To run tests
Tests present at `/src/test/java/`

  - Select test to run
  - Right Click -> Run Test -> Run as Android Test



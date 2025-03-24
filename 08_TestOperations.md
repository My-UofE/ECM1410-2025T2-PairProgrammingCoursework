### TestOperations.md (Updated 24th March 1pm updated with v4 / v5beta / v6beta)

The following instructions will let you download and run a test version of the grading script so you fix any issues with your code before submitting it.
This is not a comprehensive test of all operational requirements, but is provided to support your own testing programs. (i.e. when grading a wider set of tests will be used).

The following indicatives how the functionality covered by the tests is intended to transate into a final grade for the graded **operation** component. 

**Notes:**

i) when used in grading minor adjustments (e.g. dates, number of players etc) may be made to prevent hard-coding outputs to fake test results.  

ii) indicative grades below may subject to adjustment and the approval of the moderator).

 - Completes Tests 01 - 04: **40%+**
 - Completes Tests 01 - 05: **50%+**
 - Completes Tests 01 - 07: **60%+**
 - Completes Tests 01 - 09: **70%+**

For v5 of the tests onwards you can view the expected code output in reference text files that are added to the `TestOperation` folder.

To score **100%** you will in addition have to ensure your code fully complies with the interface and documentation so that it will pass additional testing of the functionalities and exception handling not included in Tests 01 - 09.

### Getting the tests

1. Download the TestOperation directory

```
curl -O -J -L https://github.com/My-UofE/ECM1410-2025T2-PairProgrammingCoursework/raw/refs/heads/main/TestOperation_v4.zip
```

2. Unzip. This will create a directory TestOperation in your repository (then remove the zip file to tidy up!).

```
unzip -o TestOperation_v4.zip; rm TestOperation_v4.zip
```

3. Look in the `README.md` file in the `TestOperation` directory for instructions on how to install.

### Beta version of updated TestOperations program

The `v5beta` and `v6beta` versions are new version of the TestOperations which tests the scoring.

To run `v6beta` which simulates an extended passage of time you need to add the `DateProvider` class as described in the document `AddingDateProvider.md`.

This can be found in the `TestOperation` folder after unpacking.)

I will let students try it, and once any issues have been fixed (please send me any bugs you spot) will rename them to v5 / v6 and replace the main file.

```
# FOR V5BETA
curl -O -J -L https://github.com/My-UofE/ECM1410-2025T2-PairProgrammingCoursework/raw/refs/heads/main/TestOperation_v5beta.zip
unzip -o TestOperation_v4beta.zip; rm TestOperation_v5beta.zip
```

```
# FOR V6BETA
curl -O -J -L https://github.com/My-UofE/ECM1410-2025T2-PairProgrammingCoursework/raw/refs/heads/main/TestOperation_v6beta.zip
unzip -o TestOperation_v4beta.zip; rm TestOperation_v6beta.zip
```

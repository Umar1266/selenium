# Steps for building Jenkins project

1. Open Jenkins. Create a new Jenkins job, select ```Freestyle project```. Go to ```Source Code Management```, select ```Git```.
    ```
    Repository URL: <github_repo_url>
    Credentials: none
    ```

2. Go to ```Environment```, add a ```build step```, select ```Invoke top-level Maven targets```.
    ```
    Maven Version: (default)
    Goals: clean test
    ```

3. Create the job and click on ```Build Now```
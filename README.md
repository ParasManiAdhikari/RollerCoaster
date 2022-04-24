<h1>Gitlab Orders</h1>
<p><h3>Checking the Status of Your Files</h3></p>
The main tool you use to determine which files are in which state is the git status command. If you run this command directly after a clone, you should see something like this:

<p><ins>$ git status</ins><p>
<p><ins>On branch master</ins><p>
<p><ins>Your branch is up-to-date with 'origin/master'.</ins><p>
<p><ins>nothing to commit, working tree clean</ins><p>

<p><h3>Short Status</h3></p>
If you run git status -s or git status --short you get a far more simplified output from the command:
<p><ins>$ git status -s</ins></p>
<p><ins> M README</ins></p>
<p><ins>MM Rakefile</ins></p>
<p><ins>A  lib/git.rb</ins></p>
<p><ins>M  lib/simplegit.rb</ins></p>
<p><ins>?? LICENSE.txt</ins></p>
#testparas

New files that aren’t tracked have a **??**

<p><h3>Tracking New Files</h3></p>
To begin tracking a new file, you use the command git add. To begin tracking the README file, you can run this:
<p><ins>$ git add README</ins></p>
If you run your status command again, you can see that your README file is now tracked and staged to be committed:
<p><ins>$ git status</ins><p>
<p><ins>On branch master</ins><p>
<p><ins>Your branch is up-to-date with 'origin/master'.</ins><p>
<p><ins>Changes to be committed:</ins><p>
 <p><ins> (use "git restore --staged <file>..." to unstage)</ins><p>
  <p><ins>  new file:   README</ins><p>

if (<ins>git add test.c</ins>) and then we **updated** the (test.c) file then we **must** (<ins>git add test.c</ins>) again or the Git will take only the first add without the update.


<p><h3>Committing Your Changes</h3></p>
<p><ins>$ git commit -m "commit massege here"</ins></p>

 Adding the -a option to the git commit command makes Git automatically stage every file that is already tracked before doing the commit, letting you skip the git add part:
<p><ins>$ git commit -a -m 'Add new benchmarks'</ins></p>



<p><h3>Removing Files</h3></p>
The git rm command does that and removes the file from your working directory so you don’t see it as an untracked file the next time around.
<p><ins>$ rm PROJECTS.md</ins></p>
<p><ins>$ git status</ins></p>
<p><ins>On branch master</ins></p>
<p><ins>Your branch is up-to-date with 'origin/master'.</ins></p>
<p><ins>Changes not staged for commit:</ins></p>
 <p><ins> (use "git add/rm <file>..." to update what will be committed)</ins></p>
 <p><ins> (use "git checkout -- <file>..." to discard changes in working directory)</ins></p>      
 <p><ins>deleted:    PROJECTS.md</ins></p>
<p><ins>no changes added to commit (use "git add" and/or "git commit -a")</ins></p>

Then, if you run git rm, it stages the file’s removal:
<p><ins>$ git rm PROJECTS.md</ins></p>
<p><ins>rm 'PROJECTS.md'</ins></p>
<p><ins>$ git status</ins></p>
<p><ins>On branch master</ins></p>
<p><ins>Your branch is up-to-date with 'origin/master'.</ins></p>
<p><ins>Changes to be committed:</ins></p>
 <p><ins> (use "git reset HEAD <file>..." to unstage)</ins></p>
  <p><ins>  deleted:    PROJECTS.md</ins></p>


<p><h3>Viewing the Commit History</h3></p>
he most basic and powerful tool to do this is the git log command.

<ins>git log -p</ins>  : to see the difference in the commits



<p><h3>retrieve a file from the staging area into the working tree</h3></p>
to take back what u did but without making the ADD to Git (Working Tree)
<p><ins>git checkout -- filename </ins></p>
<p><h3>retrieve a file from the latest commit into the staging area</h3></p>
to take back what u did but after making the ADD to Git and before the commit (Staging area)
<p><ins>git reset HEAD filename </ins></p>
and then u need to (because it is now in the Working tree area) 
<p><ins>git checkout -- filename  </ins> </p>

<p><h3>retrieve a file from a previous commit</h3></p>

if we delete any file that we committed it already then, we want to know the commit Hash, so we see the log of the file we want to restore
<p>1-<ins> git log – file name</ins></p>
the we take the 5 chars from the commit Hash and then:
<p>3-<ins> git checkout (commit hash first 5 chars in the commit hash) -- filename </ins></p>


<p><h1>Branches</h1></p>

<p><h3>show the branches </h3></p>
<ins>git branch</ins> :  the Head will be Green


<p><h3>create a branch </h3></p>
<ins>git branch (branch-name) </ins>


<p><h3>Change the branch/checkout a branch/move head pointer</h3></p>

<ins>git checkout (branch-name)</ins> = will change the current branch to the (branch-name)


<p><h3>see the diff between 3 branches</h3></p>
<ins>git diff master..Other</ins>

<p><h3>merge branches</h3></p>
<p><ins>git merge (branch-name)</ins>  = (fast-forward and 3-way merges)</p>

 <p><ins>git branch --merged</ins> = see branches merged into the current branch</p>

<p><h3>delete a branch</h3></p>
 <p><ins>git branch -d (branch-name)</ins>  = only if already merged</p>
 <p><ins>git branch -D (branch-name)</ins> = delete a branch, including if not already merged (exercise caution here) </p>

<p><h3>merge conflict situation</h3></p>
<ins>git merge --abort</ins> = abort a merge during a merge conflict situation





<p><h1>Remotes</h1></p>
Retrieve/download from a remote 
 <ins>git fetch (remote name)</ins>

<p><h3>merge branch or tracking-branch</h3></p>
 git merge (branch or tracking branch name) ex.: <ins>git merge origin/master</ins>

<p><h3>2 Step in one</h3></p>
We can do the fetch and merge in one step with 
<ins>git pull</ins>

<p><h3>push into origin master branch</h3></p>
to push into GitHub, we need to push it to the origin and select the branch ex.:
<ins>git push origin master</ins>     (origin is GitHub and master is our branch)

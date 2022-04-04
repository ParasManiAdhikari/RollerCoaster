<p><b>Checking the Status of Your Files</b></p>
The main tool you use to determine which files are in which state is the git status command. If you run this command directly after a clone, you should see something like this:

<ins>$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
nothing to commit, working tree clean</ins>

<p><b>Short Status</b></p>
If you run git status -s or git status --short you get a far more simplified output from the command:
<ins>$ git status -s
 M README
MM Rakefile
A  lib/git.rb
M  lib/simplegit.rb
?? LICENSE.txt</ins>

New files that aren’t tracked have a **??**

<p><b>Tracking New Files</b></p>
To begin tracking a new file, you use the command git add. To begin tracking the README file, you can run this:
<ins>$ git add README</ins>
If you run your status command again, you can see that your README file is now tracked and staged to be committed:
<ins>$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
    new file:   README
</ins>
if (<ins>git add test.c</ins>) and then we **updated** the (test.c) file then we **must** (<ins>git add test.c</ins>) again or the Git will take only the first add without the update.


<p><b>Committing Your Changes</b></p>
<ins>$ git commit -m "commit massege here"</ins>

 Adding the -a option to the git commit command makes Git automatically stage every file that is already tracked before doing the commit, letting you skip the git add part:
<ins>$ git commit -a -m 'Add new benchmarks'</ins>



<p><b>Removing Files</b></p>
The git rm command does that and removes the file from your working directory so you don’t see it as an untracked file the next time around.
<ins>$ rm PROJECTS.md
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes not staged for commit:
  (use "git add/rm <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)      deleted:    PROJECTS.md
no changes added to commit (use "git add" and/or "git commit -a")</ins>

Then, if you run git rm, it stages the file’s removal:
<ins>$ git rm PROJECTS.md
rm 'PROJECTS.md'
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)
    deleted:    PROJECTS.md
</ins>

<p><b>Viewing the Commit History</b></p>
he most basic and powerful tool to do this is the git log command.

<ins>git log -p</ins>  : to see the difference in the commits



<p><b>retrieve a file from the staging area into the working tree</b></p>
to take back what u did but without making the ADD to Git (Working Tree)
<ins>git checkout -- filename </ins>
<p><b>retrieve a file from the latest commit into the staging area</b></p>
to take back what u did but after making the ADD to Git and before the commit (Staging area)
<ins>git reset HEAD filename </ins>
and then u need to (because it is now in the Working tree area) 
<ins>git checkout -- filename  </ins> 

<p><b>retrieve a file from a previous commit</b></p>

if we delete any file that we committed it already then, we want to know the commit Hash, so we see the log of the file we want to restore
1-<ins> git log – file name</ins>
the we take the 5 chars from the commit Hash and then:
2-<ins> git checkout (commit hash first 5 chars in the commit hash) -- filename </ins>


<p><b>Branches</b></p>

<p><b>show the branches </b></p>
<ins>git branch</ins> :  the Head will be Green


<p><b>create a branch </b></p>
<ins>git branch (branch-name) </ins>


<p><b>Change the branch/checkout a branch/move head pointer</b></p>

<ins>git checkout (branch-name)</ins> = will change the current branch to the (branch-name)


<p><b>see the diff between 2 branches</b></p>
<ins>git diff master..Other</ins>

<p><b>merge branches</b></p>
<ins>git merge (branch-name)</ins>  = (fast-forward and 3-way merges)

 <ins>git branch --merged</ins> = see branches merged into the current branch

<p><b>delete a branch</b></p>
 <ins>git branch -d (branch-name)</ins>  = only if already merged
 <ins>git branch -D (branch-name)</ins> = delete a branch, including if not already merged (exercise caution here) 

<p><b>merge conflict situation</b></p>
<ins>git merge --abort</ins> = abort a merge during a merge conflict situation





<p><b><strong>Remotes</strong>
Retrieve/download from a remote 
 <ins>git fetch (remote name)</ins>

<p><b>merge branch or tracking-branch</b></p>
 git merge (branch or tracking branch name) ex.: <ins>git merge origin/master</ins>

<p><b>2 Step in one</b></p>
We can do the fetch and merge in one step with 
<ins>git pull</ins>

<p><b>push into origin master branch</b></p>
to push into GitHub, we need to push it to the origin and select the branch ex.:
<ins>git push origin master</ins>     (origin is GitHub and master is our branch)

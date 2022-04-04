** Checking the Status of Your Files**
The main tool you use to determine which files are in which state is the git status command. If you run this command directly after a clone, you should see something like this:

$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
nothing to commit, working tree clean

**Short Status**
If you run git status -s or git status --short you get a far more simplified output from the command:
$ git status -s
 M README
MM Rakefile
A  lib/git.rb
M  lib/simplegit.rb
?? LICENSE.txt

New files that aren’t tracked have a ??

**Tracking New Files**
To begin tracking a new file, you use the command git add. To begin tracking the README file, you can run this:
$ git add README
If you run your status command again, you can see that your README file is now tracked and staged to be committed:
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
    new file:   README

if (git add test.c) and then we updated the (test.c) file then we must (git add test.c) again or the Git will take only the first add without the update.


**Committing Your Changes**
$ git commit -m "commit massege here"

 Adding the -a option to the git commit command makes Git automatically stage every file that is already tracked before doing the commit, letting you skip the git add part:
$ git commit -a -m 'Add new benchmarks'



**Removing Files**
The git rm command does that and removes the file from your working directory so you don’t see it as an untracked file the next time around.
$ rm PROJECTS.md
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes not staged for commit:
  (use "git add/rm <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)      deleted:    PROJECTS.md
no changes added to commit (use "git add" and/or "git commit -a")

Then, if you run git rm, it stages the file’s removal:
$ git rm PROJECTS.md
rm 'PROJECTS.md'
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)
    deleted:    PROJECTS.md


**Viewing the Commit History**
he most basic and powerful tool to do this is the git log command.

git log -p  : to see the difference in the commits



**retrieve a file from the staging area into the working tree**
to take back what u did but without making the ADD to Git (Working Tree)
git checkout -- filename 
retrieve a file from the latest commit into the staging area
to take back what u did but after making the ADD to Git and before the commit (Staging area)
git reset HEAD filename 
and then u need to (because it is now in the Working tree area) 
git checkout -- filename   

**retrieve a file from a previous commit**

if we delete any file that we committed it already then, we want to know the commit Hash, so we see the log of the file we want to restore
1- git log – file name
the we take the 5 chars from the commit Hash and then:
2- git checkout (commit hash first 5 chars in the commit hash) -- filename 


****Branches****

**show the branches **
git branch :  the Head will be Green


**create a branch **
git branch (branch-name) 


**Change the branch/checkout a branch/move head pointer**

git checkout (branch-name) = will change the current branch to the (branch-name)


**see the diff between 2 branches**
git diff master..Other

**merge branches**
git merge (branch-name)  = (fast-forward and 3-way merges)

 git branch --merged = see branches merged into the current branch

**delete a branch**
 git branch -d (branch-name)  = only if already merged
 git branch -D (branch-name) = delete a branch, including if not already merged (exercise caution here) 

**merge conflict situation **
git merge --abort = abort a merge during a merge conflict situation





****Remotes****
Retrieve/download from a remote 
 git fetch (remote name)

**merge branch or tracking-branch **
 git merge (branch or tracking branch name) ex.: git merge origin/master

**2 Step in one**
We can do the fetch and merge in one step with 
git pull

**push into origin master branch**
to push into GitHub, we need to push it to the origin and select the branch ex.:
git push origin master     (origin is GitHub and master is our branch)

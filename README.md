[[_TOC_]]

# What is GIT used for?

Unless otherwise explicitly stated, your deliverables are submitted via GitLab in this course. The last commit pushed before the deadline to the master branch on GitLab is decisive for the evaluation, grading, and feedback. You can also use this repository to prepare the presentation of programming task attempts for bonus points and feedback. Push your current state to this repository before the presentation, and the built-in code highlighting makes it easy to navigate and check out your attempt right here in GitLab. Achieved points will be published using Moodle. The latter, i.e., Moodle, will also cover your **Programming Tasks** feedback.

**Do not change the name of the master branch**: it must be called master. Only data that is in the master branch before the deadline (therefore committed **and** pushed before the deadline) will be taken into account during the submission interviews and evaluation. Double-check that you use the correct repository (i.e., the one relevant for this semester and this course). 

# What folders are given and what are they for?

We have added some predefined folders for you. Use them to hand in/upload your programming task submission for the respective programming task exercise. While doing so, please ensure:

- The implementation of the programming task is complete, compiles, and is executable.
- That you have stored your programming task implementations in the matching "to be graded" folders. Add only the attempts you want us to consider for grading there. Please store additional incomplete attempts from other programming tasks in a separate independent folder. We have already provided a specialized folder for this.
- Please do not rename or change the predefined folders. Enable us to determine what task you have tackled by adding a short ReadMe to your implementation and name the project folders accordingly (e.g., Programming Task 1, Concurrency, etc.). Ensure that the given information denotes which programming task you tried to tackle. 
- If you add or tackle multiple programming tasks, create separate projects for them. **Do not** store or upload your submissions (including code) in compressed files (i.e., **no** .zip, **no** .rar, **no** .7z, etc.). We must be able to import (and run) your project in Eclipse.
- Cover each programming task with precisely one project. Example: Programming task two focuses on UDP and TCP. Still, it must be covered in one project, and the logic for both (UDP/TCP) must be placed in one project folder. You can use, e.g. packages to separate different classes and components inside a project.

# How do I get local access to this repository?

To work optimally with this repository, you should mirror it to your local workstation. To do this, use the `git clone <yourRepoUrl>` command. To get hold of the required repository URL scroll up till you see a blue button labeled Clone - click it. Select the URL provided by “Clone with HTTPS”. This should be similar to https://git01lab.cs.univie.ac.at/......

An alternative would be “Clone with SSH”. We typically only recommend it if you have already a bit of experience with Git and SSH. For example, because this would require you to create public and private keys for authentication reasons.  

**Problems with the certificates**: If you are experiencing problems cloning your Git repository and you are experiencing problems with certificate validation, a quick solution is to turn it off (as a last resort). You can use the following command: git config --global http.sslVerify false

If you work concurrently on multiple programming tasks the use of branches and branching based **source code management strategies** is recommended. The assignment provides tips and recommendations on this area. If you want to learn about branches in a relaxed tutorial environment we recommend to check out https://try.github.io/ Dont'f forget to merge, before the deadline, each relevant branch back into the master branch when a programming task implementation was completed.

# How do I use this repository?

Clone this repository as indicated above. Then you can interact with it based on standard git commands, such as, `git add`, `commit`, `push`, `checkout` etc. To do so you will need to specify your name and email address after the initial clone. This information is subsequently automatically used during each commit. Use the following commands to do so:

> `git config --global user.name "My name"`

> `git config --global user.email a123456@univie.ac.at`

Use your **real name** (i.e., not a nickname or an abbreviation) and your official **university mail address** (mandatory).

# How are questions handled and how is support provided?

The `Tips and Recommendations` collection on Moodle gives an overview of different scenarios and recommended ways to contact us and get support. In the following, a short overview will be provided. In addition to the asynchronous methods listed below, synchronous UE slots are available:

- For **general inquiries** (which you deem relevant for **multiple colleagues**) please use the **Moodle forums**. In case of **individual questions** (which you deem relevant for **one person**), we recommend using **GitLab issues**. 

- Contact our **tutor first**. Especially for questions related to the implementation of a programming task. If our tutors cannot assist, they will forward your inquiry to the relevant supervisor. 

- To **contact our tutors**, create a GitLab Issue and add one of the following Git handles into your issue description text. The subsequently listed tutor(s) are available: 

    - `Samuel Mitterrutzner (Git handle @samuelm00)`

In case of **high-level questions** on the programming tasks and their assigments, you can also contact your supervisor directly. For this you can attend, e.g., the weekly UE slots and present programming task approaches or receive tips and recommendations. For example, if you see multiple design options and are trying to decide which one to use. Here, the experience of your supervisor can be tapped to guide you on your DSE journey. For weeks without UE slots, you can also use **GitLab issues** to contact them.

Your **supervisor** will switch during the semester. Till the first exam, your supervisor is `Kristof Böhmer (Git handle @boehmek2)`; afterwards, it will be `Georg Simhandl (Git handle @georgs74)`.

**If nobody responds**: If you want to contact a tutor or supervisor, **always use their Git handles in your issues description text**. Such that the respective person is notified about your inquiry by GitLab. To repeat: Do not assign a Git issue. We are only notified if you add the Git handle directly into the description text. **Do not use** @all as this would notify all supervisors, including those that are not relevant for you.

As a last resort, you can contact the course [email](mailto:dse@swa.univie.ac.at) or tutor [email](mailto:dse.tutor@swa.univie.ac.at). 

# Where will feedback and grades/points be published?

We will support you by publishing feedback and grades/points (both on Moodle) on your programming task attempts during the semester. You can find both in your DSE Moodle course grade book. 

In addition you can attend the programming task focussed lecture slots to present your attempts, receive feedback and discuss your ideas with your supervisor.


# Which functions should not be used?

GitLab is a powerful software that allows you to customize numerous settings and choose from various features. We would advise you to treat these settings and features with **respect and care**. For example, by simply clicking on each button, ignoring warnings etc. one could delete this repositorie’s master branch for good (no we can’t restore it eather). So: Think before you click!


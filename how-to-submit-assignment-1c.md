### Step 1: Fork the Project

1. Log in to GitHub: Go to [GitHub](https://github.com) and log in to your account.
2. Navigate to the Template Project: Visit the project repository at `https://github.com/collin-cosc-2436/cybernetic-organs-system`.
3. Fork the Repository:
    - Click the "Fork" button at the top right of the repository page.
    - This will create a copy of the repository under your own GitHub account.

### Step 2: Clone Your Forked Repository

1. Go to Your Forked Repository: After forking, navigate to the repository in your account. This repository in your github account should have same name as original `cybernetic-organs-system`.  
2. Clone the Repository:
    - Click on the "Code" button (green) and copy the URL.
    - Open a terminal or command prompt on your local machine.
    - Use the following command to clone the repository to your local machine:

   ```bash
   git clone https://github.com/your-username/cybernetic-organs-system.git
   ```
   Replace `your-username` with your GitHub username. 


### Step 3: Open the Project in IntelliJ IDEA (or VS Code)

1. Open IntelliJ IDEA or VS Code.
2. Open the Project:
    - In IntelliJ:
        - Go to `File` > `Open`.
        - Navigate to the cloned repository folder on your local machine and open it.
    - In VS Code:
        - Click `Open Folder` in the start page.
        - Select the cloned repository folder.

### Step 4: Work on Assignment 1c

1. Create a New Branch (Recommended):
    - You can use GIT Tool in IntelliJ IDEA or VS Code to create a new branch. OR  
    - Open a terminal inside your IDE or use the command line and Create and switch to a new branch:
   ```bash
   git checkout -b assignment-1c
   ```

2. Add Your Work:
    - Add the necessary files or make changes as required for assignment 1c.

### Step 5: Commit Your Changes

1. Using Command Line:
    - Stage your changes:

   ```bash
   git add .
   ```
    - Commit the changes:

   ```bash
   git commit -m "Completed assignment 1c"
   ```

2. Using IntelliJ IDEA:
    - Go to `Git` > `Commit`.
    - Add a commit message like "Completed assignment 1c".
    - Click `Commit` (and optionally push).

3. Using VS Code:
    - Click on the `Source Control` icon (left sidebar).
    - Type a commit message like "Completed assignment 1c".
    - Click on the `✓ Commit` button.

### Step 6: Push Your Changes to GitHub

1. Push the Branch to Your Forked Repository:
    - Use the following command in the terminal:

   ```bash
   git push origin assignment-1c
   ```
    - If using IntelliJ or VS Code, use the `Push` option in the Git menu.

### Step 7: Submit the Assignment on Canvas

1. Get the Branch URL:
    - Go to your forked repository on GitHub.
    - Switch to the `assignment-1c` branch.
    - Copy the URL from your browser.

2. Submit on Canvas:
    - Log in to the Canvas portal.
    - Navigate to the assignment submission page.
    - Paste the URL of your `assignment-1c` branch into the submission box and submit.



# Text Processing Tool Application

This repository contains the **Text Processing Tool** application, which allows users to perform various text processing tasks such as regex matching, searching, replacing, and managing collections of text data. The app is built with JavaFX and follows the MVC (Model-View-Controller) pattern.

## Table of Contents

1. [Overview](#overview)
2. [Classes](#classes)
   - [ViewCollectionController](#viewcollectioncontroller)
   - [TextProcessingController](#textprocessingcontroller)
3. [Features](#features)
   - [Text Matching](#text-matching)
   - [Text Searching](#text-searching)
   - [Text Replacing](#text-replacing)
   - [Collection Management](#collection-management)
   - [Import/Export](#importexport)
4. [How to Use](#how-to-use)
   - [Adding Text to Collection](#adding-text-to-collection)
   - [Viewing Collection](#viewing-collection)
   - [Searching and Replacing Text](#searching-and-replacing-text)
   - [Importing and Exporting Files](#importing-and-exporting-files)

## Overview

The **Text Processing Scrum** application allows users to manipulate text through various functionalities, including searching and replacing text based on regex patterns. It supports adding and viewing collections of text entries, along with importing and exporting text files.

### Key Features:
- Regex-based text matching and searching
- Add text to a collection and manage it
- Import text files and export edited text
- Validation and error handling
- User notifications for successful or failed operations

## Classes

### ViewCollectionController

The `ViewCollectionController` class is responsible for managing the user interface related to viewing and managing the collection of text data. It interacts with the `CollectionDAO` to retrieve and delete text entries.

#### Key Methods:
- **delete(MouseEvent event)**: Deletes a selected text collection item from the collection and the database.
- **initialize()**: Sets up the table for displaying the text collection, initializes columns, and configures the editable cells.
- **setDataCollection(List<DataCollection> all)**: Passes a list of text collections to be displayed in the table view.

#### Attributes:
- **collections_table**: The table view that displays the collection of text entries.
- **data**: A `TableColumn` for displaying the text data.
- **id_column**: A `TableColumn` for displaying the ID of each collection item.
- **delete**: A `Button` to delete selected items from the collection.

### TextProcessingController

The `TextProcessingController` class handles text processing tasks, including regex-based operations like matching, searching, replacing, and managing text collections. It also handles file imports and exports.

#### Key Methods:
- **addToCollection(MouseEvent event)**: Adds the current text in the text area to the collection if it passes validation.
- **viewCollection(MouseEvent event)**: Opens a window to view and manage the collection of text data.
- **match(MouseEvent event)**: Matches the text in the text area against a regex pattern and provides feedback on success or failure.
- **replace(MouseEvent event)**: Replaces text matching a regex pattern with the specified replacement.
- **search(MouseEvent event)**: Searches for a regex pattern in the text and highlights the matches.
- **importFile()**: Opens a file dialog to import a text file and loads its content into the text area.
- **exportToFile()**: Opens a file dialog to save the current text in the text area to a text file.

#### Attributes:
- **case_sensitive**: A `CheckBox` to toggle case sensitivity for regex operations.
- **add_to_collection**: A `Button` to add the current text to the collection.
- **view_collection**: A `Button` to view the current collection.
- **error_query**, **error_regex**, **error_text**: Labels to display validation errors.
- **query**, **regex**, **text**: Text fields and area for inputting query, regex, and text.
- **searchResult**: A `TextFlow` to display search results and highlighted matches.
- **export_button**, **import_button**: Buttons to handle file export and import.

## Features

### Text Matching

The **match** function checks if the current text in the text area matches the provided regex query. It validates the input and displays a notification whether the match is found or not.

- **Inputs**: Regex pattern, text.
- **Validation**: Ensures the regex pattern and text are not null.
- **Output**: Notification toast indicating whether the match was found.

### Text Searching

The **search** function searches the text in the text area based on the provided regex pattern and highlights the matches. It displays the results with the matching text highlighted and provides feedback to the user.

- **Inputs**: Regex pattern, text.
- **Output**: Highlighted search results within the `TextFlow` component.

### Text Replacing

The **replace** function allows users to replace matched text with a new value based on a regex pattern. The replaced text is then displayed in the text area.

- **Inputs**: Regex pattern, replacement text, original text.
- **Output**: Replaced text displayed in the text area.

### Collection Management

The **addToCollection** method allows users to add text entries to a collection stored in a database. The **viewCollection** method opens a window where users can view, edit, or delete collection entries.

- **addToCollection**:
  - **Validation**: Ensures the text is not null before adding.
  - **Storage**: Text is saved in the database as a `DataCollection` object.

- **viewCollection**:
  - Displays a table of all stored text entries.
  - Allows users to delete or edit entries.

### Import/Export

The application supports file import and export functionality. Users can import text files to populate the text area or export the current text to a new file.

- **importFile()**: Opens a file dialog to select and import a `.txt` file into the text area.
- **exportToFile()**: Saves the current text in the text area to a selected `.txt` file.

## How to Use

### Adding Text to Collection

1. Enter text into the text area.
2. Click the **Add to Collection** button.
3. If the text is valid, it will be added to the collection and saved to the database. A notification will appear confirming the addition.

### Viewing Collection

1. Click the **View Collection** button.
2. A new window will open, displaying all text entries in the collection.
3. You can delete or edit any entry in the collection.

### Searching and Replacing Text

1. Enter a regex pattern into the **Regex** field.
2. Enter the text you wish to search or replace in the **Text** field.
3. Click **Search** to find matching text or **Replace** to replace the matching text with the specified query.

### Importing and Exporting Files

- **Importing**: Click the **Import** button to select a `.txt` file from your system. The contents will be loaded into the text area.
- **Exporting**: Click the **Export** button to save the current text to a `.txt` file on your system.

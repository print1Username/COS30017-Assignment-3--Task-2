# COS30017 Assignment-3: Task 2
  COS 30017 Software Development for Mobile Devices - Assignment 3: Task 2

[English](README.md) | [简体中文](README.zh-CN.md)

## Introduction

This Android application was created for COS30017 Assignment 3, Task 2. It reads event information from a text file and displays the events in two categories: Social Event and Professional Event.

Users can switch between the categories, view event details in a two-column card layout, and select a card to open the event website inside the application.

## Main Features

- Reads event data from `app/src/main/assets/data.txt`.
- Keeps the original event order and separates events by type.
- Uses `TabLayout` and `ViewPager2` for category navigation.
- Uses a separate Fragment for each event category.
- Displays events with `RecyclerView`, `StaggeredGridLayoutManager`, and `CardView`.
- Shows each event's image, date, title, and location.
- Opens the selected event URL in a new Fragment with a `WebView`.
- Returns to the event list with the Android system back button.

## Requirements

- Android Studio
- Android SDK 37
- An Android emulator or physical device running Android 7.0 (API 24) or later
- Internet access for Gradle dependencies and event websites
- Git, if cloning from the command line

The project uses Gradle 9.6.0, Android Gradle Plugin 9.4.1, and Java 11 source compatibility.

## Clone the Project

```bash
git clone https://github.com/print1Username/COS30017-Assignment-3--Task-2.git
cd COS30017-Assignment-3--Task-2
```

You can also download the repository as a ZIP file from GitHub and extract it to a local folder.

## Open and Configure in Android Studio

1. Open Android Studio and select **Open**.
2. Choose the cloned `COS30017-Assignment-3--Task-2` folder.
3. Allow Android Studio to trust the project if requested.
4. Wait for Gradle Sync to finish.
5. If Android SDK 37 is missing, install it from **Tools > SDK Manager**.
6. Keep the default Gradle JDK selected by Android Studio unless the IDE reports a compatibility problem.
7. Create an API 24 or later emulator from **Tools > Device Manager**, or connect an Android device with USB debugging enabled.

## Run the Application

1. Select the `app` run configuration.
2. Select an emulator or connected Android device.
3. Click **Run**.
4. Use the two tabs to switch between the event categories.
5. Select an event card to open its website in the in-app WebView.
6. Press the Android system back button to return to the event list.

The WebView needs an internet connection. A website may show its own error page if the original URL in the supplied data is no longer available.

## How the Application Works

1. `EventData` reads `data.txt` from the assets folder.
2. Each complete record is stored as an `Event` object.
3. Events are filtered into `social` and `professional` categories.
4. `EventPagerAdapter` creates the Fragment for the selected tab.
5. Each Fragment sends its event list to `EventAdapter`.
6. `EventAdapter` displays the event information in cards.
7. When a card is selected, its URL is passed to `MainActivity`.
8. `MainActivity` opens `EventWebViewFragment`, which loads the URL in a WebView.

## Project Structure

```text
app/src/main/
|-- assets/
|   `-- data.txt                         # Original event information
|-- java/com/example/cos30017assignment3_task2/
|   |-- Event.kt                         # Event data model
|   |-- EventData.kt                     # Reads and filters event data
|   |-- EventAdapter.kt                  # Binds events to card views
|   |-- EventPagerAdapter.kt             # Creates the category Fragments
|   |-- SocialEventsFragment.kt          # Displays social events
|   |-- ProfessionalEventsFragment.kt    # Displays professional events
|   |-- EventWebViewFragment.kt          # Loads an event website
|   `-- MainActivity.kt                  # Controls tabs and navigation
|-- res/
|   |-- drawable/                        # Event images and drawables
|   |-- layout/                          # Screen and card layouts
|   `-- values/                          # Strings, colours, and themes
`-- AndroidManifest.xml                  # App settings and Internet permission
```

## Data and Image Notes

The assignment-provided `data.txt` must not be edited or rearranged. It contains 10 events: 6 social events and 4 professional events.

Images are loaded from `app/src/main/res/drawable/` using the names in `data.txt`. The `anime.png` image for AnimeXcess is not currently included, so that event may show an empty image area. Another image should not be used as a replacement.

## Assignment Scope

This repository contains only Task 2: Data Presentation using ViewPager2. It does not include the Task 1 sandwich-ordering application.

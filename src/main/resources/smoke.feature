Feature:
  As a user
  I want to test all main features of the site
  To be sure that everything works correctly

  Scenario Outline: Check adding a product to the cart
    Given User opens '<homePage>' of the site
    And User checks visibility of search field
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product on the search page
    And User clicks on add to cart button
    And User clicks on cart button
    Then User checks that the Cart has aimed product '<product>'

    Examples:
      | homePage                | keyword           | product                                                                     |
      | https://www.amazon.com/ | iPhone 12 pro max | Apple iPhone 11 Pro Max, 512GB, Midnight Green - Unlocked (Renewed Premium) |

  Scenario Outline: Filtered goods under price
    Given User opens '<homePage>' of the site
    And User checks visibility of search field
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks up to
    Then User checks that list of products contains smartphones under <price>

    Examples:
      | homePage                | keyword    | price |
      | https://www.amazon.com/ | smartphone | 100   |

  Scenario: Check correctness of total price in the cart
    Given User opens 'https://www.amazon.com/' of the site
    And User checks visibility of All menu
    And User clicks on All menu
    And User clicks on Electronics
    And User clicks on Cameras&Photo
    And User clicks on Digital Cameras
    And User clicks on Blackmagic  Design Pocket Cinema
    And User clicks on Add to Cart
    And User clicks Cart button
    When User increase amount of products in cart
    Then User check that total price is 3885.00

  Scenario Outline: Check correctness of removing products from the cart
    Given User opens '<homePage>' of the site
    And User checks visibility of search field
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product on the search page
    And User clicks on add to cart button
    And User clicks on cart button
    When User clicks on delete
    Then User checks that cart has <amount> of goods

    Examples:
      | homePage                | keyword                                                                     | amount |
      | https://www.amazon.com/ | Apple iPhone 11 Pro Max, 512GB, Midnight Green - Unlocked (Renewed Premium) | 0      |

  Scenario: Check that delivery country changed
    Given User opens ' https://www.amazon.com/' of the site
    And User checks visibility of Delivery to
    And User clicks on Delivery to
    And User clicks on chose country dropdown
    When User clicks on Delivery Country Uzbekistan
    And clicks on Done button
    Then Delivery Country changed to 'Uzbekistan'

  Scenario Outline: Check logging in with valid credentials:
    Given User opens '<homePage>' of the site
    And User clicks on sign in
    And User input valid '<email>'
    And clicks Continue button
    And User input valid '<password>'
    When User clicks on Sign-in button
    Then User signed-in on the site and get '<message>'

    Examples:
      | homePage                | email                    | password | message      |
      | https://www.amazon.com/ | hereonearth692@gmail.com | 1234abcd | Hello, Anton |

    Scenario: User checks that he gets to select payment method page after clicking on BuyNow button
      Given User opens 'https://www.amazon.com/' of the site
      And User clicks on sign in
      And User input valid 'hereonearth692@gmail.com'
      And clicks Continue button
      And User input valid '1234abcd'
      And User clicks on Sign-in button
      And User checks visibility of search field
      And User makes search by keyword ' Apple iPhone 11 Pro Max, 512GB, Midnight Green - Unlocked (Renewed Premium)'
      And User clicks search button
      And User clicks on first product on the search page
      And User clicks on Buy Now button
      When User clicks Use this address
      Then User checks that he on the page 'Select a payment method'
      #I stopped on this page because Amazon demands your real credit card to proceed

  Scenario: Check buying a product through cart
    Given User opens 'https://www.amazon.com/' of the site
    And User clicks on sign in
    And User input valid 'hereonearth692@gmail.com'
    And clicks Continue button
    And User input valid '1234abcd'
    And User clicks on Sign-in button
    And User checks visibility of All menu
    And User clicks on All menu
    And User clicks on Electronics
    And User clicks on Cameras&Photo
    And User clicks on Digital Cameras
    And User clicks on Blackmagic  Design Pocket Cinema
    And User clicks on Add to Cart
    And User clicks Cart button
    And User checks visibility of product in cart
    And User clicks on Proceed to checkout button
    When User clicks Use this address
    Then User checks that he on the page 'Select a payment method'
     #I stopped on this page because Amazon demands your real credit card to proceed

  Scenario: Check logging in with invalid email
    Given User opens 'https://www.amazon.com/' of the site
    And User clicks on sign in
    And User input invalid  email "vhjvhvhjhjhj@gmail.com"
    When User clicks on Continue button
    Then User get validation message 'There was a problem'

  Scenario: Check that Customers who bought items in your cart also bought carousel is on the cart page
    Given User opens 'https://www.amazon.com/' of the site
    And User clicks on sign in
    And User input valid 'hereonearth692@gmail.com'
    And clicks Continue button
    And User input valid '1234abcd'
    And User clicks on Sign-in button
    And User checks visibility of All menu
    And User clicks on All menu
    And User clicks on Electronics
    And User clicks on Cameras&Photo
    And User clicks on Digital Cameras
    And User clicks on Blackmagic  Design Pocket Cinema
    And User clicks on Add to Cart
    And User clicks Cart button
    When User checks visibility of product in cart
    Then User checks that 'Customers who bought items in your cart also bought' is visible












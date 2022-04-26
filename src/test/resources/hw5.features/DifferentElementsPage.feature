Feature: User can perform actions on Different Elements page

  @smoke
  Scenario: User can edit checkboxes, radio buttons and dropdown menu
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    Then Browser title equals "Home Page"
    And Name is displayed and equals "ROMAN IOVLEV"
    When I click on "Service" button in Header menu
    And I click on "Different elements" button in Service dropdown
    And I select checkboxes in main form on Different Elements page
      | Water |
      | Wind  |
    And I select radio button in main form on Different Elements page
      | Selen |
    And I select color from dropdown menu in main form on Different Elements page
      | Yellow |
    Then I see logs in right section on Different Elements page
      | Colors: value changed to Yellow  |
      | metal: value changed to Selen    |
      | Wind: condition changed to true  |
      | Water: condition changed to true |

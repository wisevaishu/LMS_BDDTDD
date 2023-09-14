Feature: Admin validates navigation to the other pages from Program page



Background: Admin is on dashboard page after login and clicks

Given Admin is on Manage Program page



@Tag_001

Scenario Outline: Verify admin is able to navigate to "<page>" from Program page

  Given Admin is on the Program page after login

  When Admin clicks the "<page>" button in the navigation bar from program page

  Then Admin should be able to land on the "<page>"  link page



  Examples:

    | page         |

    | Student      |

    | Program      |

    | Batch        |

    | User         |

    | Assignment   |

    | Class        |

  

	

@Tag_002

Scenario: Logout link on navigation bar

	When Admin clicks on "Logout" link on Manage program page

	Then Admin is redirect to "Login" page from Manage Program page
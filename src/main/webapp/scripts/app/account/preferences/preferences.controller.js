'use strict';

angular.module('tatamiJHipsterApp')
    .controller('PreferencesController', function($scope, $translate, Account, profileInfo, ProfileService, PreferencesService, ngToast) {
        $scope.profile = profileInfo;
        $scope.userPreferences = profileInfo.data;

        $scope.savePrefs = function() {
           $scope.validatePrefs();
           PreferencesService.save($scope.userPreferences, function() {
               ngToast.create({
                   content: $translate.instant('account.preferences.save')
               });
           }, function() {
               ngToast.create({
                   content: $translate.instant('form.fail'),
                   class: 'danger'
                   });
           });
        };

        $scope.validatePrefs = function() {
            for(var pref in $scope.profile) {
                if($scope.profile.hasOwnProperty(pref) && $scope.profile[pref] === null) {
                    if('rssUid' === $scope.profile[pref]) {
                        continue;
                    }
                    $scope.profile[pref] = false;
                }
            }
        };
    });